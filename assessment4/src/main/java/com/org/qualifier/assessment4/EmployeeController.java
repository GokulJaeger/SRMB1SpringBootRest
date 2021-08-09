package com.org.qualifier.assessment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController{
    @Autowired
    private IEmployeeDao empDao;

@RequestMapping(path="/wel",method=RequestMethod.GET)
   public String Welcome(){
    return "Assessment 4";

}
@RequestMapping(path="/employee",method=RequestMethod.POST)
@ResponseStatus(code=HttpStatus.CREATED)
public void addEmployee(@RequestBody Employee emp){
    empDao.save(emp);

}

@GetMapping(path="/employee")
public Employee getEmployee(@RequestParam(name="id")Integer id){
return empDao.findById(id).get();
}
}