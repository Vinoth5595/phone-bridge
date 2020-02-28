import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CampaignConstants } from './campaign-constants';
import { CampaignService } from './campaign-service';
import { Observable } from 'rxjs';
import * as $ from 'jquery';

@Component({
  selector: 'app-campaign',
  templateUrl: './campaign.component.html',
  styleUrls: ['./campaign.component.scss']
})
export class CampaignComponent implements OnInit {
  campaignForm: FormGroup;
  campaignResponseData: Observable<any>;
  sjonObj: any;

  //START CAMPAIGN
  label_campaign_name: string;
  label_campaign_status: string;
  label_type_of_call: string;
  label_call_direction: string;
  label_is_enabled_for_popup: string;
  label_is_default: string;

  //CAMPAIGN INCOMING
  label_didnumber: string;
  label_queuenames: string;
  label_cti_postback_url: string;

  //CAMPAIGN OUTGOING
  label_is_extension_wise: string;
  label_no_of_client_tries: string;
  label_no_of_agent_tries: string;
  label_retry_after: string;
  label_trunk_name: string;
  label_prefix: string;
  label_dial_out_wait_time_in_secs: string;

  //CAMPAIGN POPUP
  label_module_name: string;
  label_directory_info_url: string;
  label_wrap_up_time_in_secs: string;
  label_campaign_feed_source: string;

  //Disposition
  label_field_data_type: string;
  label_drop_down_value: string;
  label_field_label: string;
  label_call_workflow: string;
  label_dependent_list: string;
  label_send_sms: string;
  label_sms_text: string;
  label_conversion: string;

  //ShowField
  label_sf_field_label: string;
  label_display_field: string;
  label_is_url: string;

  //CampaignPopupIncoming
  label_iframe_url: string;

  constructor(private fb: FormBuilder, private campaignService: CampaignService) { }

  ngOnInit() {
    //START CAMPAIGN
    this.label_campaign_name = CampaignConstants.LABEL_CAMPAIGN_NAME;
    this.label_campaign_status = CampaignConstants.LABEL_CAMPAIGN_STATUS;
    this.label_type_of_call = CampaignConstants.LABEL_TYPE_OF_CALL;
    this.label_call_direction = CampaignConstants.LABEL_CALL_DIRECTION;
    this.label_is_enabled_for_popup = CampaignConstants.LABEL_IS_ENABLED_FOR_POPUP;
    this.label_is_default = CampaignConstants.LABEL_IS_DEFAULT;

    //CAMPAIGN INCOMING
    this.label_didnumber = CampaignConstants.LABEL_DID_NUMBER;
    this.label_queuenames = CampaignConstants.LABEL_QUEUE_NAMES;
    this.label_cti_postback_url = CampaignConstants.LABEL_CTI_POSTBACK_URL;

    //CAMPAIGN OUTGOING
    this.label_is_extension_wise = CampaignConstants.LABEL_IS_EXTENSION_WISE;
    this.label_no_of_client_tries = CampaignConstants.LABEL_NO_OF_CLIENT_TRIES;
    this.label_no_of_agent_tries = CampaignConstants.LABEL_NO_OF_AGENT_TRIES;
    this.label_retry_after = CampaignConstants.LABEL_RETRY_AFTER;
    this.label_trunk_name = CampaignConstants.LABEL_TRUNK_NAME;
    this.label_prefix = CampaignConstants.LABEL_PREFIX;
    this.label_dial_out_wait_time_in_secs = CampaignConstants.LABEL_DIAL_OUT_WAIT_TIME_IN_SECS;

    //CAMPAIGN POPUP
    this.label_module_name = CampaignConstants.LABEL_MODULE_NAME;
    this.label_directory_info_url = CampaignConstants.LABEL_DIRECTORY_INFO_URL;
    this.label_wrap_up_time_in_secs = CampaignConstants.LABEL_WRAP_UP_TIME_IN_SECS;
    this.label_campaign_feed_source = CampaignConstants.LABEL_CAMPAIGN_FEED_SOURCE;

    //Disposition
    this.label_field_data_type = CampaignConstants.LABEL_FIELD_DATA_TYPE;
    this.label_drop_down_value = CampaignConstants.LABEL_DROP_DOWN_VALUES;
    this.label_field_label = CampaignConstants.LABEL_FIELD_LABEL;
    this.label_call_workflow = CampaignConstants.LABEL_CALL_WORKFLOW;
    this.label_dependent_list = CampaignConstants.LABEL_DEPENDENT_LIST;
    this.label_send_sms = CampaignConstants.LABEL_SEND_SMS;
    this.label_sms_text = CampaignConstants.LABEL_SMS_TEXT;
    this.label_conversion = CampaignConstants.LABEL_CONVERSION;

    //ShowField
    this.label_sf_field_label = CampaignConstants.LABEL_SF_FIELD_LABEL;
    this.label_display_field = CampaignConstants.LABEL_DISPLAY_FIELD;
    this.label_is_url = CampaignConstants.LABEL_IS_URL;

    //CampaignPopupIncoming
    this.label_iframe_url = CampaignConstants.LABEL_IFRAME_URL;


    this.campaignForm = this.fb.group({
      campaignName: "AirtelSupport",
      callDirection: "INCOMING",
      campaignStatus: "Active",
      isEnabledForPopup: true,
      typeOfCall: "QUEUE_INCOMING",
      isDefault: true,
      campaignIncomingSettings: this.fb.group({
        didNumbers: this.fb.array([
          this.fb.control('277003')
        ]),
        queueNames: this.fb.array([
          this.fb.control('3000')
        ]),
        ctiPostBackUrl: ['']
      }),
      campaignOutgoingSettings: this.fb.group({
        isExtensionWise: [""],
        noOfClientTries: [""],
        noOfAgentTries: [""],
        retryAfter: [""],
        trunkName: this.fb.array([
          this.fb.control('')
        ]),
        prefix: [""],
        dialOutWaitTimeInSecs: [""]
      }),
      campaignPopup: this.fb.group({
        moduleName: ["customer"],
        directoryInfoURL: ["test.com"],
        wrapUpTimeInSecs: ["30"],
        campaignFeedSource: ["ModuleLinked"],
        dispositions: this.fb.array([this.createDisposition()]),
        showFields: this.fb.array([this.createShowFields()]),
        campaignPopupIncoming: this.fb.group({
          iFrameUrl: ''
        })
      }),
    });
  }

  createDisposition(): FormGroup {
    return this.fb.group({
      fieldDataType: 'DropDown',
      dropDownValues: this.fb.array([
        this.fb.control('Resolved')
      ]),
      fieldLabel: 'Resolution',
      callWorkFlow: '',
      dependantDisp: this.fb.array([
        this.fb.control('')
      ]),
      sendSMS: false,
      smsText: '',
      conversion: false,
    });
  }

  createShowFields(): FormGroup {
    return this.fb.group({
      fieldLabel: '',
      displayField: '',
      isUrl: false,
    });
  }

  get didNumbers_array() {
    return this.campaignForm.get('campaignIncomingSettings').get('didNumbers') as FormArray;
  }

  get queuenames_array() {
    return this.campaignForm.get('campaignIncomingSettings').get('queueNames') as FormArray;
  }

  get trunkname_array() {
    return this.campaignForm.get('campaignOutgoingSettings').get('trunkName') as FormArray;
  }

  get disposition_arr() {
    return this.campaignForm.get('campaignPopup').get('dispositions') as FormArray;
  }

  get showfields_array() {
    return this.campaignForm.get('campaignPopup').get('showFields') as FormArray;
  }

  get dropdown_array() {
    return this.campaignForm.get('campaignPopup').get('dispositions').get('dropDownValues') as FormArray;
  }

  addDidNumbers(): void {
    console.log('inside addDidNumbers');
    this.didNumbers_array.push(this.fb.control(''));
  }

  removeDidNumbers(): void {
    console.log('inside removeDidNumbers');
    this.didNumbers_array.removeAt(this.didNumbers_array.length - 1);
  }

  addQueueNames(): void {
    console.log('inside addQueueNames');
    this.queuenames_array.push(this.fb.control(''));
  }

  removeQueueNames(): void {
    console.log('inside removeQueueNames');
    this.queuenames_array.removeAt(this.queuenames_array.length - 1);
  }

  addTrunkName(): void {
    console.log('inside addTrunkName');
    this.trunkname_array.push(this.fb.control(''));
  }

  removeTrunkName(): void {
    console.log('inside removeTrunkName');
    this.trunkname_array.removeAt(this.trunkname_array.length - 1);
  }

  addDropDownValues(): void {
    console.log('inside addDropDownValues');
    this.dropdown_array.push(this.fb.control(''));
  }

  removeDropDownValues(): void {
    console.log('inside removeDropDownValues');
    this.dropdown_array.removeAt(this.dropdown_array.length - 1);
  }

  addDisposition(): void {
    console.log('inside addDisposition');
    this.disposition_arr.push(this.createDisposition());
  }

  removeDisposition(): void {
    console.log('inside removeDisposition');
    this.disposition_arr.removeAt(this.disposition_arr.length - 1);
  }

  addShowFields(): void {
    console.log('inside addShowFields');
    this.showfields_array.push(this.createShowFields());
  }

  removeShowFields(): void {
    console.log('inside removeShowFields');
    this.showfields_array.removeAt(this.showfields_array.length - 1);
  }

  onSubmit(): void {
    console.log('Form Submitted');
    this.campaignResponseData = this.campaignService.postCampaignData(
      this.campaignForm.value
    );
  }
}
