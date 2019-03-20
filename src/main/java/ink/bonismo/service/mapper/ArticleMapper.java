package ink.bonismo.service.mapper;

import ink.bonismo.domain.Article;
import ink.bonismo.service.dto.ArticleDTO;
import org.mapstruct.Mapper;

/**
 * Created by bonismo@hotmail.com on 2019/3/20 1:16 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Mapper(componentModel = "spring",uses = {})
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {

    default Article fromId(Long id) {
        if (id == null) {
            return null;
        }
        Article article = new Article();
        article.setId(id);
        return article;
    }
}
