package com.example.springjourney.project.controller;

import com.example.springjourney.project.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    //controller method using query params approach
    /*
    @GetMapping("/holidays")
    public String getHolidays(@RequestParam(required=false) boolean festival,
                              @RequestParam(required=false) boolean federal, Model model){
        model.addAttribute("festival", festival) ;
        model.addAttribute("federal",federal) ;

        ArrayList<Holiday> holidays = new ArrayList<Holiday>();
        holidays.add(new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL)) ;
        holidays.add(new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL)) ;
        holidays.add(new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL)) ;
        holidays.add(new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL)) ;
        holidays.add(new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL)) ;
        holidays.add(new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL)) ;
        holidays.add(new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL)) ;
        holidays.add(new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)) ;

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }

    */

    // controller method using path variable method
    @GetMapping("/holidays/{display}") // whatever the dynamic value sent from the ui will be
                                          // assigned to this variable display
    public String getHolidays(@PathVariable String display, Model model){

        if(display != null && display.equals("all")){
            model.addAttribute("festival",true) ;
            model.addAttribute("federal",true) ;
        }else if(display !=null && display.equals("festival")){
            model.addAttribute("festival",true) ;
        }else if(display !=null && display.equals("federal")){
            model.addAttribute("federal",true) ;
        }

        ArrayList<Holiday> holidays = new ArrayList<Holiday>();
        holidays.add(new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL)) ;
        holidays.add(new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL)) ;
        holidays.add(new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL)) ;
        holidays.add(new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL)) ;
        holidays.add(new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL)) ;
        holidays.add(new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL)) ;
        holidays.add(new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL)) ;
        holidays.add(new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)) ;

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
