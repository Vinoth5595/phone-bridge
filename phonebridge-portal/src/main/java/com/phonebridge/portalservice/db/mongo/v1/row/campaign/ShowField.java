/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonebridge.portalservice.db.mongo.v1.row.campaign;

import com.phonebridge.portalservice.db.mongo.v1.row.BasePojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShowField extends BasePojo{
    private String fieldLabel;
    private String displayField;
    private String showFieldID;
    private boolean isUrl;
}
