package com.health.service;

import com.health.dto.InsurencePolicyDto;
import com.health.model.InsurencePolicy;
import com.health.utility.StatusMsg;

public interface IInsurencePolicyService {

	public StatusMsg addInsurence(InsurencePolicyDto policy,Long patientId);
	public InsurencePolicy getInsurence(Long insurenceId);
	public InsurencePolicy updateInsurence(InsurencePolicy policy,Long insurenceId);
	public Long deleteInsurence(Long insurenceId);
	public Double getInsurenceAmount(Long insurenceId );
}
