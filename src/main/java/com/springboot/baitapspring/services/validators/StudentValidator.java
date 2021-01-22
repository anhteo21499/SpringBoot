package com.springboot.baitapspring.services.validators;

import com.springboot.baitapspring.exception.Exceptions;
import com.springboot.baitapspring.model.in.ClassRequest;
import com.springboot.baitapspring.model.in.StudentRequest;

import java.util.regex.Pattern;

public class StudentValidator {
    public static StudentRequest validateObjectSave(StudentRequest studentRequest){
        return Validator.of(studentRequest)
                .validate(student->student.getPhone(), phones -> checkSDT(phones), ()-> new Exceptions("Please provide a valid phone number"))
                // nhận vào 1 userSaveRequest (hàm function<t,u> chyển thành đối tượng kiểu String  userName hoặc password,  lấy kết quả userName vào hàm checkUserNameIsBlank hoặc pass
                //get ra là get đối tượng của runtimeException nếu lỗi , còn nêu vượt qua thì sử lí tiếp và lấy ra giá trị đã khởi tạo là userSaveRequest
                .get();
    }
    private static boolean checkSDT(String phone){
        Pattern pattern = Pattern.compile("(09|01[2|6|8|9])+([0-9]{8})");
        return pattern.matcher(phone).matches()? false : true ;
    }




}
