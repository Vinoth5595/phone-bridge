/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonebridge.row.campaign;

import com.phonebridge.row.BasePojo;

import lombok.Data;

@Data
public class ShowField extends BasePojo{
    private String fieldLabel;
    private String displayField;
    private String showFieldID;
    private boolean isUrl;
}
