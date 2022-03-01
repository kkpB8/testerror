/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.devglan.model;


import org.springframework.stereotype.Component;

/**
 * @Microware
 */
@Component
public class UsersRoleRightsMapping {

  public static final String TABLE_NAME = "user_role_rights_map";
  public static final String ID_COLUMN = "id";
  public static final String USERID_COLUMN = "user_id";
  public static final String ROLEID_COLUMN = "role_id";
  public static final String CATEGORYID_COLUMN = "category_id";
  public static final String STATE_ID_COLUMN = "state_id";
  public static final String DISTRICT_ID_COLUMN = "district_id";
  public static final String BLOCK_ID_COLUMN = "block_id";
  public static final String PANCHAYAT_ID_COLUMN = "panchayat_id";
  public static final String VILLAGE_ID_COLUMN = "village_id";

  
}
