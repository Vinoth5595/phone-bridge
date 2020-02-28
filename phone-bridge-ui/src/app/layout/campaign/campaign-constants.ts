export class CampaignConstants {
    //START CAMPAIGN
    private static _LABEL_CAMPAIGN_NAME: string = "Campaign Name";
    private static _LABEL_CAMPAIGN_STATUS: string = "Campaign Status";
    private static _LABEL_TYPE_OF_CALL: string = "Type Of Call";
    private static _LABEL_CALL_DIRECTION: string = "Call Direction";
    private static _LABEL_IS_ENABLED_FOR_POPUP: string = "Is Enabled For Popup";
    private static _LABEL_IS_DEFAULT: string = "Is Default";

    //CAMPAING INCOMING
    private static _LABEL_DID_NUMBER: string = "Did Number";
    private static _LABEL_QUEUE_NAMES: string = "Queue Names";
    private static _LABEL_CTI_POSTBACK_URL: string = "CTI Postback URL";

    //CAMPAIGN OUTGOING
    private static _LABEL_IS_EXTENSION_WISE: string = "Is Extension wise";
    private static _LABEL_NO_OF_CLIENT_TRIES: string = "No of client tries";
    private static _LABEL_NO_OF_AGENT_TRIES: string = "No of agent tries";
    private static _LABEL_RETRY_AFTER: string = "Retry after";
    private static _LABEL_TRUNK_NAME: string = "Trunk name";
    private static _LABEL_PREFIX: string = "Prefix";
    private static _LABEL_DIAL_OUT_WAIT_TIME_IN_SECS: string = "Dial out wait time in secs";

    //CAMPAIGN POPUP
    private static _LABEL_MODULE_NAME: string = "Module name";
    private static _LABEL_DIRECTORY_INFO_URL: string = "Directory Info URL";
    private static _LABEL_WRAP_UP_TIME_IN_SECS: string = "Wrap up time in Secs";
    private static _LABEL_CAMPAIGN_FEED_SOURCE: string = "Campaign Feed Source";

    //Disposition
    private static _LABEL_FIELD_DATA_TYPE: string = "Field Data type";
    private static _LABEL_DROP_DOWN_VALUES: string = "Drop down values";
    private static _LABEL_FIELD_LABEL: string = "Field label";
    private static _LABEL_CALL_WORKFLOW: string = "Call workflow";
    private static _LABEL_DEPENDENT_LIST: string = "Dependent list";
    private static _LABEL_SEND_SMS: string = "Sent SMS";
    private static _LABEL_SMS_TEXT: string = "SMS Text";
    private static _LABEL_CONVERSION: string = "Conversion";

    //ShowField
    private static _LABEL_SF_FIELD_LABEL: string = "Field label";
    private static _LABEL_DISPLAY_FIELD: string = "Display Field";
    private static _LABEL_IS_URL: string = "Is URL";

    //CampaignPopupIncoming
    private static _LABEL_IFRAME_URL: string = "IFrame URL";

    public static get LABEL_CAMPAIGN_NAME(): string {
        return CampaignConstants._LABEL_CAMPAIGN_NAME;
    }

    public static set LABEL_CAMPAIGN_NAME(value: string) {
        CampaignConstants._LABEL_CAMPAIGN_NAME = value;
    }

    public static get LABEL_CAMPAIGN_STATUS(): string {
        return CampaignConstants._LABEL_CAMPAIGN_STATUS;
    }
    public static set LABEL_CAMPAIGN_STATUS(value: string) {
        CampaignConstants._LABEL_CAMPAIGN_STATUS = value;
    }

    public static get LABEL_TYPE_OF_CALL(): string {
        return CampaignConstants._LABEL_TYPE_OF_CALL;
    }
    public static set LABEL_TYPE_OF_CALL(value: string) {
        CampaignConstants._LABEL_TYPE_OF_CALL = value;
    }

    public static get LABEL_CALL_DIRECTION(): string {
        return CampaignConstants._LABEL_CALL_DIRECTION;
    }
    public static set LABEL_CALL_DIRECTION(value: string) {
        CampaignConstants._LABEL_CALL_DIRECTION = value;
    }

    public static get LABEL_IS_ENABLED_FOR_POPUP(): string {
        return CampaignConstants._LABEL_IS_ENABLED_FOR_POPUP;
    }
    public static set LABEL_IS_ENABLED_FOR_POPUP(value: string) {
        CampaignConstants._LABEL_IS_ENABLED_FOR_POPUP = value;
    }

    public static get LABEL_IS_DEFAULT(): string {
        return CampaignConstants._LABEL_IS_DEFAULT;
    }
    public static set LABEL_IS_DEFAULT(value: string) {
        CampaignConstants._LABEL_IS_DEFAULT = value;
    }

    public static get LABEL_DID_NUMBER(): string {
        return CampaignConstants._LABEL_DID_NUMBER;
    }
    public static set LABEL_DID_NUMBER
        (value: string) {
        CampaignConstants._LABEL_DID_NUMBER = value;
    }

    public static get LABEL_QUEUE_NAMES(): string {
        return CampaignConstants._LABEL_QUEUE_NAMES;
    }
    public static set LABEL_QUEUE_NAMES
        (value: string) {
        CampaignConstants._LABEL_QUEUE_NAMES = value;
    }

    public static get LABEL_CTI_POSTBACK_URL(): string {
        return CampaignConstants._LABEL_CTI_POSTBACK_URL;
    }
    public static set LABEL_CTI_POSTBACK_URL(value: string) {
        CampaignConstants._LABEL_CTI_POSTBACK_URL = value;
    }

    public static get LABEL_NO_OF_CLIENT_TRIES(): string {
        return CampaignConstants._LABEL_NO_OF_CLIENT_TRIES;
    }
    public static set LABEL_NO_OF_CLIENT_TRIES(value: string) {
        CampaignConstants._LABEL_NO_OF_CLIENT_TRIES = value;
    }

    public static get LABEL_IS_EXTENSION_WISE(): string {
        return CampaignConstants._LABEL_IS_EXTENSION_WISE;
    }
    public static set LABEL_IS_EXTENSION_WISE(value: string) {
        CampaignConstants._LABEL_IS_EXTENSION_WISE = value;
    }

    public static get LABEL_NO_OF_AGENT_TRIES(): string {
        return CampaignConstants._LABEL_NO_OF_AGENT_TRIES;
    }
    public static set LABEL_NO_OF_AGENT_TRIES(value: string) {
        CampaignConstants._LABEL_NO_OF_AGENT_TRIES = value;
    }

    public static get LABEL_RETRY_AFTER(): string {
        return CampaignConstants._LABEL_RETRY_AFTER;
    }
    public static set LABEL_RETRY_AFTER
        (value: string) {
        CampaignConstants._LABEL_RETRY_AFTER = value;
    }

    public static get LABEL_TRUNK_NAME(): string {
        return CampaignConstants._LABEL_TRUNK_NAME;
    }
    public static set LABEL_TRUNK_NAME
        (value: string) {
        CampaignConstants._LABEL_TRUNK_NAME = value;
    }

    public static get LABEL_PREFIX(): string {
        return CampaignConstants._LABEL_PREFIX;
    }
    public static set LABEL_PREFIX(value: string) {
        CampaignConstants._LABEL_PREFIX = value;
    }

    public static get LABEL_DIAL_OUT_WAIT_TIME_IN_SECS(): string {
        return CampaignConstants._LABEL_DIAL_OUT_WAIT_TIME_IN_SECS;
    }
    public static set LABEL_DIAL_OUT_WAIT_TIME_IN_SECS(value: string) {
        CampaignConstants._LABEL_DIAL_OUT_WAIT_TIME_IN_SECS = value;
    }

    public static get LABEL_MODULE_NAME(): string {
        return CampaignConstants._LABEL_MODULE_NAME;
    }
    public static set LABEL_MODULE_NAME
        (value: string) {
        CampaignConstants._LABEL_MODULE_NAME = value;
    }

    public static get LABEL_DIRECTORY_INFO_URL(): string {
        return CampaignConstants._LABEL_DIRECTORY_INFO_URL;
    }
    public static set LABEL_DIRECTORY_INFO_URL(value: string) {
        CampaignConstants._LABEL_DIRECTORY_INFO_URL = value;
    }

    public static get LABEL_WRAP_UP_TIME_IN_SECS(): string {
        return CampaignConstants._LABEL_WRAP_UP_TIME_IN_SECS;
    }
    public static set LABEL_WRAP_UP_TIME_IN_SECS(value: string) {
        CampaignConstants._LABEL_WRAP_UP_TIME_IN_SECS = value;
    }

    public static get LABEL_CAMPAIGN_FEED_SOURCE(): string {
        return CampaignConstants._LABEL_CAMPAIGN_FEED_SOURCE;
    }
    public static set LABEL_CAMPAIGN_FEED_SOURCE(value: string) {
        CampaignConstants._LABEL_CAMPAIGN_FEED_SOURCE = value;
    }


    public static get LABEL_FIELD_DATA_TYPE(): string {
        return CampaignConstants._LABEL_FIELD_DATA_TYPE;
    }
    public static set LABEL_FIELD_DATA_TYPE(value: string) {
        CampaignConstants._LABEL_FIELD_DATA_TYPE = value;
    }


    public static get LABEL_DROP_DOWN_VALUES(): string {
        return CampaignConstants._LABEL_DROP_DOWN_VALUES;
    }
    public static set LABEL_DROP_DOWN_VALUES(value: string) {
        CampaignConstants._LABEL_DROP_DOWN_VALUES = value;
    }

    public static get LABEL_FIELD_LABEL(): string {
        return CampaignConstants._LABEL_FIELD_LABEL;
    }
    public static set LABEL_FIELD_LABEL
        (value: string) {
        CampaignConstants._LABEL_FIELD_LABEL = value;
    }

    public static get LABEL_CALL_WORKFLOW(): string {
        return CampaignConstants._LABEL_CALL_WORKFLOW;
    }
    public static set LABEL_CALL_WORKFLOW
        (value: string) {
        CampaignConstants._LABEL_CALL_WORKFLOW = value;
    }


    public static get LABEL_DEPENDENT_LIST(): string {
        return CampaignConstants._LABEL_DEPENDENT_LIST;
    }
    public static set LABEL_DEPENDENT_LIST(value: string) {
        CampaignConstants._LABEL_DEPENDENT_LIST = value;
    }


    public static get LABEL_SEND_SMS(): string {
        return CampaignConstants._LABEL_SEND_SMS;
    }
    public static set LABEL_SEND_SMS(value: string) {
        CampaignConstants._LABEL_SEND_SMS = value;
    }


    public static get LABEL_SMS_TEXT(): string {
        return CampaignConstants._LABEL_SMS_TEXT;
    }
    public static set LABEL_SMS_TEXT(value: string) {
        CampaignConstants._LABEL_SMS_TEXT = value;
    }

    public static get LABEL_CONVERSION(): string {
        return CampaignConstants._LABEL_CONVERSION;
    }
    public static set LABEL_CONVERSION 
        (value: string) {
        CampaignConstants._LABEL_CONVERSION = value;
    }

    
    public static get LABEL_SF_FIELD_LABEL(): string {
        return CampaignConstants._LABEL_SF_FIELD_LABEL;
    }
    public static set LABEL_SF_FIELD_LABEL 
        (value: string) {
        CampaignConstants._LABEL_SF_FIELD_LABEL = value;
    }

    
    public static get LABEL_DISPLAY_FIELD(): string {
        return CampaignConstants._LABEL_DISPLAY_FIELD;
    }
    public static set LABEL_DISPLAY_FIELD 
        (value: string) {
        CampaignConstants._LABEL_DISPLAY_FIELD = value;
    }

    
    public static get LABEL_IS_URL(): string {
        return CampaignConstants._LABEL_IS_URL;
    }
    public static set LABEL_IS_URL(value: string) {
        CampaignConstants._LABEL_IS_URL = value;
    }

    
    public static get LABEL_IFRAME_URL(): string {
        return CampaignConstants._LABEL_IFRAME_URL;
    }
    public static set LABEL_IFRAME_URL 
        (value: string) {
        CampaignConstants._LABEL_IFRAME_URL = value;
    }
}