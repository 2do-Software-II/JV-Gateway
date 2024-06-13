package com.hotel.hotel.Services;

import org.springframework.stereotype.Service;

import com.hotel.hotel.Entities.Dashboard;

@Service
public class DashboardService {
    public Dashboard get() {
        Dashboard dashboard = new Dashboard();
        dashboard.setOptionOne(new int[] { 1, 2, 3, 4, 5 });
        dashboard.setOptionTwo(new int[] { 1, 2, 3, 4, 5 });
        dashboard.setOptionThree(new int[] { 1, 2, 3, 4, 5 });
        return dashboard;
    }

}
