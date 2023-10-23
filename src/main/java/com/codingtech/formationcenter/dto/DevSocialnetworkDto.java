package com.codingtech.formationcenter.dto;

public class DevSocialnetworkDto {

    private String  sosailnetworkName;
    private String urlSOcialNetwork;

    public DevSocialnetworkDto(String sosailnetworkName, String urlSOcialNetwork) {
        this.sosailnetworkName = sosailnetworkName;
        this.urlSOcialNetwork = urlSOcialNetwork;
    }

    public DevSocialnetworkDto() {
    }

    public String getSosailnetworkName() {
        return sosailnetworkName;
    }

    public void setSosailnetworkName(String sosailnetworkName) {
        this.sosailnetworkName = sosailnetworkName;
    }

    public String getUrlSOcialNetwork() {
        return urlSOcialNetwork;
    }

    public void setUrlSOcialNetwork(String urlSOcialNetwork) {
        this.urlSOcialNetwork = urlSOcialNetwork;
    }
}
