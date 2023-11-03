package com.file.mover.mover.schedular;

import com.file.mover.mover.SHGProfileDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

@Component
public class FileMover {


    @Value("${state.id}")
    private String stateId;

    private final SHGProfileDao shgProfileDao;

    public FileMover(SHGProfileDao shgProfileDao) {
        this.shgProfileDao = shgProfileDao;
    }

    @Scheduled(initialDelay = 1000,fixedDelay = 200000)
    public void run() throws IOException {
        System.out.println(shgProfileDao.findAll().size());
        List<String> results = new ArrayList<>();
        HashMap<String ,List<Path>> pathWithGuid=new HashMap<>();
        listFilesUsingFileWalkAndVisitor("/home/ganesh/uploadFilesV2",results).forEach(e->{
            pathTrackerAndMover(e,pathWithGuid);
        });

        System.out.println("aa");

    }


    public List<String> listFilesUsingFileWalkAndVisitor(String dir, List<String> listFiles) throws IOException {

        File folder = new File(dir);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                listFiles.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFilesUsingFileWalkAndVisitor(file.getAbsolutePath(), listFiles);
        }
        }
        return listFiles;
    }

    private HashMap<String ,List<Path>> pathTrackerAndMover(String absolutePath,HashMap<String ,List<Path>> pathWithGuid){
        String[] subDirs = absolutePath.split(Pattern.quote(File.separator));
        if(subDirs[4].equals(stateId)) {
            Path path = new Path();
            path.setOldStructure(collectOldStructure(absolutePath, subDirs));
            path.setNewStructure(collectNewStructure(path.getOldStructure()));
            if (pathWithGuid.containsKey(subDirs[8])) {
                pathWithGuid.get(subDirs[8]).add(path);

            } else {
                List<Path> pathList = new ArrayList<>();
                pathList.add(path);
                pathWithGuid.put(subDirs[8], pathList);
            }
        }
        return pathWithGuid;
    }



    public OldStructure collectOldStructure(String path,String[] sudDir){
        OldStructure oldStructure=new OldStructure();
        oldStructure.setPath(path);
        oldStructure.setStateId(sudDir[4]);
        oldStructure.setDistrictId(sudDir[5]);
        oldStructure.setBlockId(sudDir[6]);
        oldStructure.setPanchayatId(sudDir[7]);
        oldStructure.setGuId(sudDir[8]);
        oldStructure.setFileName(sudDir[9]);
        return oldStructure;
    }

    public NewStructure collectNewStructure(OldStructure oldStructure){
        NewStructure newStructure=new NewStructure();
        newStructure.setStateId(oldStructure.getStateId());
        newStructure.setBlockId(oldStructure.getBlockId());
        newStructure.setPanchayatId(oldStructure.getPanchayatId());
        newStructure.setGuId(oldStructure.getGuId());
        newStructure.setDistrictId(oldStructure.getDistrictId());
        return newStructure;
    }
}
