/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonebridge.row.cti;
import java.util.Date;
import java.util.List;

import com.phonebridge.row.BasePojo;
import com.phonebridge.row.campaign.Disposition;

import lombok.Data;

/**
 *
 * @author sonamuthu
 */
@Data
public class CallHistoryInfo extends BasePojo{
    private List<String> extension;
    private List<Disposition> selectedDispositions;
    private String comment;
    private Date callHistorylastCalledOn;
    private Double callHistoryCallDuration;

}
