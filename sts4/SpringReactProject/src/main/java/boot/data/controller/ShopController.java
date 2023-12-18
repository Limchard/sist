package boot.data.controller;

import boot.data.dto.ShopDto;
import boot.data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController // react 는 무조건 RestController 이다.
@CrossOrigin // react 는 3000 포트, 스프링은 9002포트, 같이 쓸려면 이걸 무조건 해줘야 한다.
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    String photoName; // 리액트에서 업로드한 이미지명(혹은 변경한 이미지명..)
    @PostMapping("/upload")
    public String fileUpload(@RequestParam MultipartFile uploadFile,
                             HttpServletRequest request){
        // 업로드할 폴더 위치
        String path=request.getServletContext().getRealPath("/save");

        // 파일명
        String fileName=uploadFile.getOriginalFilename(); // 이름 겹칠꺼 때문에 sdf 해줬었다.

        // 파일명 변경
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        photoName=sdf.format(new Date())+fileName;

        System.out.println("fileName: "+fileName+"==>"+photoName);

        // save 폴더에 업로드
        try {
            uploadFile.transferTo(new File(path+"/"+photoName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return photoName;
    }

    @PostMapping("/insert")
    public void insertShop(@RequestBody ShopDto dto){ // @RequestBody : json으로 보낸걸 java 클래스로 변환해야 하므로
        // 업로드한 사진으로 photo 변경해주기
        dto.setPhoto(photoName);
        // insert
        shopService.insertShop(dto);
    }

    @GetMapping("/list")
    public List<ShopDto> list(){
        return shopService.getShopDatas();
    }

    @GetMapping("/detail")
    public ShopDto detail(@RequestParam int num){
        return shopService.getData(num);
    }

}
