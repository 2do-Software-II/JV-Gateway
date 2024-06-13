package com.hotel.hotel.Resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.hotel.hotel.Entities.Dashboard;
import com.hotel.hotel.Services.DashboardService;

@Controller
public class DashboardResolver {

    @Autowired
    private DashboardService dashboardService;

    @QueryMapping()
    public Dashboard getDashboard() {
        return dashboardService.get();
    }
}
