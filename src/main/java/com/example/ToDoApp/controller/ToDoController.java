package com.example.ToDoApp.controller;
//
import com.example.ToDoApp.model.ToDo;
import com.example.ToDoApp.service.ToDoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//
//@CrossOrigin(origins = "http://localhost:8080")
//@RestController
//@Controller
//@RequestMapping("/api")
//public class ToDoController {
//
//    @Autowired
//    private ToDoService service;
//
//    @GetMapping({"/", "ViewToDoList"})
//    public String viewAllToDoItems(Model model , @ModelAttribute("message") String message){
//        model.addAttribute("list", service.getAllToDoItem());
//        model.addAttribute("msg", "message");
//        return "ViewToDoList";
//    }
//
//    @PostMapping("/updateToDoStatus/{id}")
//    public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes){
//        if (service.updateStatus(id)){
//            redirectAttributes.addFlashAttribute("message", "Update message");
//            return "redirect:/viewToDoList";
//        }
//        redirectAttributes.addFlashAttribute("message", "Update failures");
//        return "redirect:/viewToDoList";
//    }
//
//    @GetMapping("/addToDoItem")
//    public String addToDoItem(Model model){
//        model.addAttribute("todo", new ToDo());
//        return "AddToDoItem";
//    }
//
//    @PostMapping("/saveToDoItem")
//    public String saveToDoItem(ToDo todo, RedirectAttributes redirectAttributes){
//        if (service.savOrUpdateToDoItem(todo)){
//            redirectAttributes.addFlashAttribute("message", "Save success");
//            return "redirect:/viewToDoList";
//        }
//        redirectAttributes.addFlashAttribute("message", "Save failures");
//        return "redirect:/addToDoItem";
//    }
//
//    @GetMapping("/editToDoItem/{id}")
//    public String editToDoItem(@PathVariable Long id, Model model){
//        model.addAttribute("todo", service.getToDoItemById(id));
//        return "EditToDoItem";
//    }
//
//    @PostMapping("/editSaveToDoItem")
//    public String editSaveToDoItem(ToDo todo, RedirectAttributes redirectAttributes){
//        if (service.savOrUpdateToDoItem(todo)){
//            redirectAttributes.addFlashAttribute("message", "Edit success");
//            return "redirect:/viewToDoList";
//        }
//        redirectAttributes.addFlashAttribute("message", "Edit failures");
//        return "redirect:/editToDoItem" + todo.getId();
//    }
//
//    @GetMapping("/deleteToDoItem/{id}")
//    public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes){
//        if (service.deleteToDoItem(id)){
//            redirectAttributes.addFlashAttribute("message", "Delete Success");
//        }
//        redirectAttributes.addFlashAttribute("message", "Delete Failure");
//        return "redirect:/viewToDoList";
//    }
//}
//package com.example.ToDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Base URL for the API
public class ToDoController {

    @Autowired
    private ToDoService service;

    @GetMapping("/go")
    public String getAllToDoItems() {
        return "ggg";
    }

    @PostMapping("/{id}/updateStatus")
    public String updateToDoStatus(@PathVariable Long id) {
        if (service.updateStatus(id)) {
            return "Update Success";
        }
        return "Update Failure";
    }

    @PostMapping("/add")
    public String saveToDoItem(@RequestBody ToDo todo) {
        if (service.savOrUpdateToDoItem(todo)) {
            return "Save Success";
        }
        return "Save Failure";
    }

    @PutMapping("/{id}/edit")
    public String editSaveToDoItem(@PathVariable Long id, @RequestBody ToDo todo) {
        if (service.savOrUpdateToDoItem(todo)) {
            return "Edit Success";
        }
        return "Edit Failure";
    }

    @DeleteMapping("/{id}")
    public String deleteToDoItem(@PathVariable Long id) {
        if (service.deleteToDoItem(id)) {
            return "Delete Success";
        }
        return "Delete Failure";
    }
}
