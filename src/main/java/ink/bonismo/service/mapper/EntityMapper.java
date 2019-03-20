package ink.bonismo.service.mapper;

import java.util.List;

/**
 * Created by bonismo@hotmail.com on 2019/3/20 11:58 AM
 *
 * @Description:
 * @Version: 1.0
 */
public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
