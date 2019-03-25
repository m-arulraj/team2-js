package com.virtusa.semicolon.registration.resource;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtusa.semicolon.registration.domain.Registration;

@FeignClient(name="admin-service")
public interface AdminServiceProxy {
	
@RequestMapping("/api/admin/approval/requests")
public List<Registration> findall();
}
