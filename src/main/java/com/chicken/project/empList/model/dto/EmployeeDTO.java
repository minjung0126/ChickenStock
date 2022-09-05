package com.chicken.project.empList.model.dto;

import com.chicken.project.calendar.model.dto.CalendarDTO;
import com.chicken.project.store.model.dto.StoreDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmployeeDTO{

    private int empNO;
    private String empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private String managerYn;
    private String empPwd;
    private java.util.Date birth;
    private String memberType;

    private List<CalendarDTO> calendar;
    private StoreDTO storeDTO;
}