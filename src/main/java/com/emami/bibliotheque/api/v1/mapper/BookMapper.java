package com.emami.bibliotheque.api.v1.mapper;

import com.emami.bibliotheque.api.v1.model.BookDTO;
import com.emami.bibliotheque.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    com.emami.bibliotheque.api.v1.model.BookDTO bookToBookDTO(Book book);

    Book bookDtoToBook(BookDTO bookDTO);
}
