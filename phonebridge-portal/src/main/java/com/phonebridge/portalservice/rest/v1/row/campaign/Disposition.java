/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonebridge.portalservice.rest.v1.row.campaign;

import java.util.List;

import lombok.Data;

@Data
public class Disposition{ 
    private String fieldDataType;
    private List<String> dropDownValues;
    private String fieldLabel;
    private String callWorkFlow;
    private List<Disposition> dependantLst;
    private Boolean sendSMS;
    private String smsText;
    private Boolean conversion;
    
}
