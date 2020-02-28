export class CampaignOutgoingSettings {

    /* This is to provision map a list of numbers to particular extensions */
    isExtensionWise: boolean;

    /* In case the customer doesn't pick up, how many times should we retry */
    noOfClientTries: number;

    /* In case the agent doesn't pick up, how many times should we retry the agent */
    noOfAgentTries: number;

    /* In case the customer didn't pick up, after how much interval it has to be scheduled for retry */
    retryAfter: number;

    /* trunks involved in OG campaign */
    trunkName: string[];

    /* Prefix to use for Dialing out */
    prefix: string;

    /* How many seconds to wait after showing the popup before dialing out */
    dialOutWaitTimeInSecs: number;

}