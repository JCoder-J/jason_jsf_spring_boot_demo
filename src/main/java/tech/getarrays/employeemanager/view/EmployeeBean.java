package tech.getarrays.employeemanager.view;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

@Component
@SessionScope
@ELBeanName(value="employeebean")
public class EmployeeBean {
	
	private final EmployeeService employeeService;
	private String id;

    public EmployeeBean(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    
    public Employee retrieveById(Long id) {
    	return employeeService.findEmployeeById(id);
    }

    public boolean getEmployeeExists() {
        Employee employee = retrieveById(Long.valueOf(this.id));
        return employee.getName().isEmpty();
    }
    
    public String getEmployeeName(){
        Employee employee = retrieveById(Long.valueOf(this.id));
        return employee.getName();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
