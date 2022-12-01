package com.api.iyzico.model;

import com.api.iyzico.dto.InstallmentDetailDto;
import com.api.iyzico.dto.Options;
import com.api.iyzico.dto.RetrieveInstallmentInfoRequest;
import com.api.iyzico.resource.HttpClient;
import com.api.iyzico.resource.IyzipayResource;
import java.util.List;

public class InstallmentInfo extends IyzipayResource {

    private List<InstallmentDetailDto> installmentDetails;

    public static InstallmentInfo retrieve(RetrieveInstallmentInfoRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/installment",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                InstallmentInfo.class);
    }

    public List<InstallmentDetailDto> getInstallmentDetails() {
        return installmentDetails;
    }

    public void setInstallmentDetails(List<InstallmentDetailDto> installmentDetails) {
        this.installmentDetails = installmentDetails;
    }
}