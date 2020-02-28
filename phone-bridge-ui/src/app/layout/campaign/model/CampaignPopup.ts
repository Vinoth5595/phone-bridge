import { CampaignPopupIncoming } from './CampaignPopupIncoming';
import { Disposition } from './Disposition';
import { ShowField } from './ShowField';

export class CampaignPopup {
	moduleName: string;

	/* Directory URL to get info about an IC number / OG No */
	directoryInfoURL: string;

	/* No of seconds before the Popup is wrapped Up automatically */
	wrapUpTimeInSecs: number;

	campaignFeedSource: string;

	dispositions: Disposition[];
	showFields: ShowField[];

	campaignPopupIncoming: CampaignPopupIncoming;
}