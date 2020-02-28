/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonebridge.portalservice.rest.v1.row.campaign;

import lombok.Data;

@Data
public class ShowField{
    private String fieldLabel;
    private String displayField;
    private Boolean isUrl;
}
