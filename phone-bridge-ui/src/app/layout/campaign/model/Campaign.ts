import { CampaignIncomingSettings } from './CampaignIncomingSettings';
import { CampaignOutgoingSettings } from './CampaignOutgoingSettings';
import { CampaignPopup } from './CampaignPopup';

export class Campaign {
    campaignName: string;
    callDirection: string;
    campaignStatus: string;
    isEnabledForPopup: boolean;
    /* Defines the type of Campaign */
    typeOfCall: string;
    /* Default campaigns are generic those which don't fit into other campaigns */
    isDefault: boolean;

    campaignIncomingSettings: CampaignIncomingSettings;
    campaignOutgoingSettings: CampaignOutgoingSettings;
    campaignPopup: CampaignPopup;
}

