package com.seckill.web;

import com.seckill.service.SeckillService;

import java.sql.Date;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//@Service @Component
@RequestMapping("/seckill")
public class SeckillController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private SeckillService seckillService;
	
	@RequestMapping(name="/list",method = RequestMethod.GET)
	public String list(Model model) {

		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list",list);
		
		return "list";
		
	}
	
	
	@RequestMapping(value="/{seckillId}/detail",method = RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId,Model model) {
		if(seckillId == null) {
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);

		if(seckill == null) {
			return "forward:/seckill/list";
		}
		
		model.addAttribute("seckill",seckill);
		
		return "detail";
	}

	//public void/*TODO*/ exposer(Long seckillId) {
	@RequestMapping(value="/{seckillId}/exposer",
			method = RequestMethod.POST
			produces = {"application/json;charset=UTF-8"}
			)
	@ResponseBody
	public SeckillResult<Exposer> exposer(Long seckillId) {
		Seckillresult<Exposer> result;

		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true,exposer);
			
		} catch(Exception e){
			logger.error(e.getMessage(),e);
			result = new SeckillResult<Exposer>(false,e.getMessage());

			
		}

		

		return result;
				
	}
	
	@RequestMapping(value = "/{seckillId}/{md5}/execution"
			method = RequestMethod.Post,
			produces = {"application/json;charset= UTF-8"}
			)
	public SeckillResult<SeckillExecution> execute(@PathCariable("seckillId") Long seckillId,
			@PathCariable("md5") String md5,
			@CookieValue(value = "killPhone",required = false) Long phone){

		if(phone == null ) {
			return new SeckillResult<SeckillExecution>(false,"未注册");
			
		}

		SeckillResult<SeckillExecution> result;
		try {
			
			SeckillExecution execution = seckillServic.executeSeckill(seckillId,phone);
			return new SeckillResult<SeckillExcution>(true,execution);

		}catch(RepeatKillException e1){
			SeckillExecution execution = new SeckillExection(seckillId,SeckillStatEnum.REPEAT_KILL);
			return new SeckillResult<SeckillExcution>(true,execution);
			
		}catch(SeckillCloseException e2) {
			SeckillExecution execution = new SeckillExection(seckillId,SeckillStatEnum.END);
			return new SeckillResult<SeckillExcution>(true,execution);
		}catch(SeckillCloseException e) {
			SeckillExecution execution = new SeckillExection(seckillId,SeckillStatEnum.INNER_ERROR);
			return new SeckillResult<SeckillExcution>(true,execution);
		}

	}
	
	public SeckillResult<Long> time() {
		Date now = new Date();
		return new SeckillResult(true,now.getTime());
		
	}
	
	
	
	
	
	
	

	
}
