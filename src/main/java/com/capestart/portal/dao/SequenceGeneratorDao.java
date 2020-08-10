package com.capestart.portal.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceGeneratorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public long getNextSequence(final String sequenceName) {
		return jdbcTemplate.queryForObject("Select nextval(?)", new Object[] { sequenceName }, Long.class);
	}

	public List<Long> getNextSequence(final String sequenceName, final int limit) {

		return jdbcTemplate.queryForList("select nextval(?) from generate_series(1,?);",
				new Object[] { sequenceName, limit }, Long.class);
	}
}