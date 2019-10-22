package com.avm.citycenter;

import android.app.Application;

import com.avm.citycenter.pojo_classes.Campaign;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GlobalVariables extends Application {
    private ArrayList<Campaign> favouriteCampaignsList = new ArrayList<>();
    private ArrayList<Campaign> campaignsList = new ArrayList<>();
    private ArrayList<Campaign> activitiesList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        campaignsList = createSampleCampaignsList();
        activitiesList = createSampleActivitiesList();
    }

    private ArrayList<Campaign> createSampleCampaignsList() {
        ArrayList<Campaign> campaigns = new ArrayList<>();
        Date today = Calendar.getInstance().getTime();

        campaigns.add(new Campaign("Köfteci Ramiz", "Tarihte Gizlenen Eşsiz Lezzet",
                "11 Ağustos - 15 Ağustos", R.drawable.example_ramiz, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Linens", "Linens Raflar Boşalıyor %70 İndirim",
                "15 Temmuz - 31 Ağustos", R.drawable.example_linens, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("BurgerKing", "Bir menü alana 2. menü bedava",
                "11 Ağustos - 15 Ağustos", R.drawable.example_logo_burger, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Köfteci Ramiz", "İki menü 35,99TL",
                "11 Ağustos - 15 Ağustos", R.drawable.example_ramiz, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Koton", "Trikolarda %50 İndirim",
                "15 Temmuz - 31 Ağustos", R.drawable.example_logo_koton, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Mavi", "200TL alışverişe 50TL hediye",
                "15 Temmuz - 31 Ağustos", R.drawable.example_logo_mavi, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Köfteci Ramiz", "Tarihte Gizlenen Eşsiz Lezzet",
                "11 Ağustos - 15 Ağustos", R.drawable.example_ramiz, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Linens", "Linens Raflar Boşalıyor %70 İndirim",
                "15 Temmuz - 31 Ağustos", R.drawable.example_linens, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("BurgerKing", "Bir menü alana 2. menü bedava",
                "11 Ağustos - 15 Ağustos", R.drawable.example_logo_burger, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Köfteci Ramiz", "İki menü 35,99TL",
                "11 Ağustos - 15 Ağustos", R.drawable.example_ramiz, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Koton", "Trikolarda %50 İndirim",
                "15 Temmuz - 31 Ağustos", R.drawable.example_logo_koton, today, getString(R.string.example_campaign_detail), true));
        campaigns.add(new Campaign("Mavi", "200TL alışverişe 50TL hediye",
                "15 Temmuz - 31 Ağustos", R.drawable.example_logo_mavi, today, getString(R.string.example_campaign_detail), true));

        return campaigns;
    }

    private ArrayList<Campaign> createSampleActivitiesList() {
        ArrayList<Campaign> activities = new ArrayList<>();
        Date today = Calendar.getInstance().getTime();

        activities.add(new Campaign("Cinema", "Geniş Aile",
                "11 Ağustos - 15 Ağustos", R.drawable.example_genis_aile, today, getString(R.string.example_campaign_detail), false));
        activities.add(new Campaign("Petshop", "Vippet Petshop",
                "15 Temmuz - 31 Ağustos", R.drawable.example_vippet_petshop, today, getString(R.string.example_campaign_detail), false));
        activities.add(new Campaign("Cinema", "Joker",
                "11 Ekim - 15 Aralık", R.drawable.example_genis_aile, today, getString(R.string.example_campaign_detail), false));
        activities.add(new Campaign("Petshop", "Vippet Petshop",
                "15 Temmuz - 31 Ağustos", R.drawable.example_vippet_petshop, today, getString(R.string.example_campaign_detail), false));
        activities.add(new Campaign("Cinema", "Geniş Aile",
                "11 Ağustos - 15 Ağustos", R.drawable.example_genis_aile, today, getString(R.string.example_campaign_detail), false));
        activities.add(new Campaign("Petshop", "Vippet Petshop",
                "15 Temmuz - 31 Ağustos", R.drawable.example_vippet_petshop, today, getString(R.string.example_campaign_detail), false));

        return activities;
    }

    public ArrayList<Campaign> getCampaignsList() {
        return campaignsList;
    }
    public ArrayList<Campaign> getActivitiesList() {
        return activitiesList;
    }
    public ArrayList<Campaign> getFavouriteCampaignsList() {
        return favouriteCampaignsList;
    }

}
