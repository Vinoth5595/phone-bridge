/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonebridge.portalservice.db.mongo.v1.row.campaign;

import java.util.List;

import com.phonebridge.portalservice.db.mongo.v1.row.BasePojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Disposition extends BasePojo{
    private String dispositionID;
    private String fieldDataType;
    private List<String> dropDownValues;
    private String fieldLabel;
    private String callWorkFlow;
    private List<Disposition> dependantDisp;
    private boolean sendSMS;
    private String smsText;
    private boolean conversion;
}
