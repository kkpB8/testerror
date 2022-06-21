//package com.devglan.controller;
//
//import com.devglan.service.ReportService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * Used for reports that should be provided to Jasper
// */
//@Controller
//@RequestMapping("/report")
//public class ReportController {
//    private final ReportService reportService;
//
//    public ReportController(ReportService reportService) {
//        this.reportService = reportService;
//    }
//
//    /**
//     * Used to fetch state, district, block for dropdown in reports * * @param locationType - can be state, district, block, panchayat and vilalge * @param locationId   - id of parentlocationid * @return
//     */
//    @GetMapping("/location-master")
//    public ResponseEntity<?> getLocationMasters(@RequestParam("locationType") String locationType, @RequestParam("locationId") int locationId) {
//        return ResponseEntity.ok(reportService.getLocationByType(locationType, locationId));
//    }
//
//    @GetMapping("/shg-meeting")
//    public ResponseEntity<?> getShgMeetingDetail(@RequestParam("profileType") String profileType, @RequestParam("locationType") String locationType, @RequestParam("locationId") int locationId) {
//        return ResponseEntity.ok(reportService.getGenericMeetingData(profileType, locationType, locationId));
//    }
//}