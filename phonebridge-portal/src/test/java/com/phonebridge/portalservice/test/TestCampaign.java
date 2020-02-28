package com.phonebridge.portalservice.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.phonebridge.portalservice.rest.v1.req.NewCampaignRq;
import com.phonebridge.portalservice.rest.v1.row.campaign.CampaignIncomingSettings;
import com.phonebridge.portalservice.rest.v1.row.campaign.CampaignPopup;
import com.phonebridge.portalservice.rest.v1.row.campaign.Disposition;
import com.phonebridge.portalservice.rest.v1.row.campaign.ShowField;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestCampaign {

	@Autowired
    private TestRestTemplate restTemplate;
     
    @LocalServerPort
    int randomServerPort;
 
    @Test
    public void testAddICCampaignSuccess() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/campaign/v1/newCampaign";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.set("accountId", "5771644c4e00731d9bad9f33");
        headers.set("userId", "5771647b4e00731d9bad9f36");
 
        NewCampaignRq req= new NewCampaignRq();
        req.setCampaignName("AirtelSupport");
        req.setCallDirection("INCOMING");
        req.setCampaignStatus("Active");
        req.setIsEnabledForPopup(true);
        req.setTypeOfCall("QUEUE_INCOMING");
        req.setIsDefault(false);
    	
        CampaignIncomingSettings campaignIncomingSettings=new CampaignIncomingSettings();
        campaignIncomingSettings.setDidNumbers(Collections.singletonList("277003"));
        campaignIncomingSettings.setQueueNames(Collections.singletonList("3000"));
        req.setCampaignIncomingSettings(campaignIncomingSettings);
        
        CampaignPopup campaignPopup=new CampaignPopup();
        campaignPopup.setCampaignFeedSource("ModuleLinked");
        campaignPopup.setModuleName("customer");
        campaignPopup.setWrapUpTimeInSecs(30);
        
        Disposition disposition = new Disposition();
        disposition.setFieldDataType("DropDown");
        disposition.setDropDownValues(Collections.singletonList("Resolved"));
        disposition.setFieldLabel("Resolution");
        disposition.setDependantLst(Collections.emptyList());
        disposition.setSendSMS(false);
        disposition.setConversion(false);
        campaignPopup.setDispositions(Collections.singletonList(disposition));
        
        ShowField sf = new ShowField();
        sf.setFieldLabel("Customer Since");
        sf.setDisplayField("customerSince");
        sf.setIsUrl(false);
        campaignPopup.setShowFields(Collections.singletonList(sf));
        	
        req.setCampaignPopup(campaignPopup);
        
        HttpEntity<NewCampaignRq> request = new HttpEntity<>(req,headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        Assert.assertEquals(201, result.getStatusCodeValue());
    }
}
