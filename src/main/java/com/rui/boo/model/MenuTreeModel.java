package com.rui.boo.model;

import com.rui.boo.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author rui
 * @Date 2019-05-11 22:49
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuTreeModel implements Serializable {

    private Menu parent;

    private List<Menu> menus;
}
