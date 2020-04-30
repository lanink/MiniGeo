package com.liamxin.mini.geo.model.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Polygon
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020/4/30 3:39 下午
 */
@Getter
@Setter
@AllArgsConstructor
public class Polygon {
    private Point[] vertexes;
}
