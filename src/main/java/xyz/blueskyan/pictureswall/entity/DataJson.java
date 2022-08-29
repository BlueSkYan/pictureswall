package xyz.blueskyan.pictureswall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataJson {
        private Integer code;
        private String msg;
        private Map<String,String> data;

}
