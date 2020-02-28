export class CampaignIncomingSettings {
    didNumbers: string[];

    /* Incoming: For making Queue based campaigns */
    queueNames: string[];

    /* Configured to send CDRs when received */
    ctiPostBackUrl: string;
}