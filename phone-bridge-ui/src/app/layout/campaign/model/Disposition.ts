export class Disposition{ 
     fieldDataType:string;
    dropDownValues: string[];
    fieldLabel:string;
    callWorkFlow:string;
    dependantLst:Disposition[];
    sendSMS:boolean;
    smsText:string;
    conversion:boolean;
}
