package com.example.springboot_junit_demo.RetrofitTest.HnWhiteList;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description 
 * @Author wjf 
 * @Date 2022-03-25 
 */

@Data
public class ProblemWhitelist implements Serializable {

	private static final long serialVersionUID = 3679741440943363862L;

	private String id;

	/**
	 * 车牌号码
	 */
	private String plateNumber;

	/**
	 * 车牌颜色
	 */
	private Integer plateColor;

	/**
	 * 行业
	 */
	private String industry;

	/**
	 * 规则id
	 */
	private String ruleId;

	/**
	 * 规则名称
	 */
	private String ruleName;

	/**
	 * 有效期开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private LocalDate effectiveStartDate;

	/**
	 * 有效期结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private LocalDate effectiveEndDate;

	/**
	 * 附件id
	 */

	private String attachId;

	private String attachName;

	/**
	 * 附件url
	 */
	private String attachUrl;

	private Integer removed = 0;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime createdTime;

	private String createdBy;

//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//	private LocalDateTime updatedTime;
	private String updatedTime;

	private String updatedBy;


	/**
	 *白名单类型：1:企业；2:车辆
	 */
	private Integer ruleObject;


}
