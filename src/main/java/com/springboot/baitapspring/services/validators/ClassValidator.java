package com.springboot.baitapspring.services.validators;

import com.springboot.baitapspring.exception.Exceptions;
import com.springboot.baitapspring.exception.NotFoundException;
import com.springboot.baitapspring.model.in.ClassRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ClassValidator {
    public static ClassRequest validateObjectSave(ClassRequest classRequest){
        return Validator.of(classRequest)
                .validate(classes-> classes.getName() , name -> checkClassIsBlank(name), ()-> new NotFoundException("empty class names"))
                .get();
                // nhận vào 1 userSaveRequest (hàm function<t,u> chyển thành đối tượng kiểu String  userName hoặc password,  lấy kết quả userName vào hàm checkUserNameIsBlank hoặc pass
                //get ra là get đối tượng của runtimeException nếu lỗi , còn nêu vượt qua thì sử lí tiếp và lấy ra giá trị đã khởi tạo là userSaveRequest

    }
    private static boolean checkClassIsBlank(String name){
        return StringUtils.isBlank(name) ? true : false;
    }


}
