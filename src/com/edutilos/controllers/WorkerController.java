package com.edutilos.controllers;


import com.edutilos.main1.Worker;
import com.edutilos.main1.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WorkerController {
    @Autowired
    private WorkerDAO workerDAO;


    @RequestMapping(value = "/allWorkers", method = RequestMethod.GET)
    public ModelAndView getAllWorkersView() {
        ModelAndView mv = new ModelAndView("allWorkers");
        mv.addObject("workers", workerDAO.findAll());
        return mv ;
    }


    @RequestMapping(value = "/allWorkersRest", method =  RequestMethod.GET)
    public @ResponseBody List<Worker> getAllWorkersRest() {
        return workerDAO.findAll();
    }


    @RequestMapping(value="/addWorkerGet", method = RequestMethod.GET)
    public ModelAndView addWorkerGet() {
       return new ModelAndView("addWorker", "command", new Worker());
    }

    @RequestMapping(value="/addWorkerPost", method =  RequestMethod.POST)
    public String addWorkerPost(@ModelAttribute Worker worker , ModelMap model) {
        workerDAO.save(worker);
        worker = workerDAO.findById(worker.getId());
        model.addAttribute("id", worker.getId());
        model.addAttribute("name", worker.getName());
        model.addAttribute("age", worker.getAge());
        model.addAttribute("wage", worker.getWage());
      return "addWorkerResult";
    }


    @RequestMapping(value="/updateWorkerGet/{id}", method = RequestMethod.GET)
    public ModelAndView updateWorkerGet(@PathVariable("id")long id) {
        Worker w = workerDAO.findById(id);
        if(w == null) return addWorkerGet();
        return new ModelAndView("updateWorker", "command", w);
    }


    @RequestMapping(value="/updateWorkerPost")
    public String updateWorkerPost(@ModelAttribute Worker worker, ModelMap model) {
        workerDAO.update(worker.getId(), worker);
        worker = workerDAO.findById(worker.getId());
        model.addAttribute("worker", worker);
        return "updateWorkerResult";
    }

}
