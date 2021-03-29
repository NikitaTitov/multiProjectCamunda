package ru.nikita.library.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.nikita.library.dto.test.Parent;
import ru.nikita.library.dto.test.ParentDTO;

@Mapper
public interface ParentMapper {

	ParentMapper MAPPER = Mappers.getMapper(ParentMapper.class);

	@Mapping(target = "id", source = "parentId")
	@Mapping(target = "child.id", source = "childId")
	Parent toEntity(ParentDTO parentDTO);

	@Mapping(source = "id", target = "parentId")
	@Mapping(source = "child.id", target = "childId")
	ParentDTO toDTO(Parent parent);
}
