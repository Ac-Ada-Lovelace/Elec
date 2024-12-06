package com.zys.elec.service;

import com.zys.elec.common.ServiceResult;
import com.zys.elec.entity.User;

public interface SignUpSerivce {

    ServiceResult<String> signUp(User user);
}
