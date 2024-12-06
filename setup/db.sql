-- 기존 데이터베이스가 있다면 삭제
DROP DATABASE IF EXISTS db_dokalab_blog;

-- 데이터베이스 생성
CREATE DATABASE db_dokalab_blog CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE db_dokalab_blog;

-- 기존 테이블들이 있다면 외래키 제약조건으로 인한 삭제 순서 문제를 방지하기 위해 삭제
DROP TABLE IF EXISTS tbl_post_tags;
DROP TABLE IF EXISTS tbl_post_article;
DROP TABLE IF EXISTS tbl_post_meta;
DROP TABLE IF EXISTS tbl_tag;
DROP TABLE IF EXISTS tbl_category;

-- 테이블: tbl_category
CREATE TABLE tbl_category (
                              category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              category_name TEXT NOT NULL,
                              parent_id BIGINT NULL,
                              FOREIGN KEY (parent_id) REFERENCES tbl_category(category_id)
) ENGINE=InnoDB;

-- 테이블: tbl_tag
CREATE TABLE tbl_tag (
                         tag_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         tag_name TEXT NOT NULL,
                         UNIQUE (tag_name(255))
) ENGINE=InnoDB;

-- 테이블: tbl_post_meta
CREATE TABLE tbl_post_meta (
                               post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               post_title TEXT NOT NULL,
                               created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                               is_visible BOOLEAN DEFAULT TRUE NOT NULL,
                               status ENUM('draft', 'published') DEFAULT 'published' NOT NULL,
                               category_id BIGINT NOT NULL,
                               FOREIGN KEY (category_id) REFERENCES tbl_category(category_id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 테이블: tbl_post_article
CREATE TABLE tbl_post_article (
                                  post_id BIGINT PRIMARY KEY,
                                  article LONGTEXT NOT NULL,
                                  FOREIGN KEY (post_id) REFERENCES tbl_post_meta(post_id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 테이블: tbl_post_tags
CREATE TABLE tbl_post_tags (
                               post_id BIGINT NOT NULL,
                               tag_id BIGINT NOT NULL,
                               PRIMARY KEY (post_id, tag_id),
                               FOREIGN KEY (post_id) REFERENCES tbl_post_meta(post_id) ON DELETE CASCADE,
                               FOREIGN KEY (tag_id) REFERENCES tbl_tag(tag_id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 게시물 제목 (post_title)에 FULLTEXT 인덱스 추가 (ngram 파서 적용)
ALTER TABLE tbl_post_meta ADD FULLTEXT(post_title) WITH PARSER ngram;

-- 게시물 본문 (article)에 FULLTEXT 인덱스 추가 (ngram 파서 적용)
ALTER TABLE tbl_post_article ADD FULLTEXT(article) WITH PARSER ngram;

-- 태그 이름에 대한 검색 인덱스
CREATE INDEX idx_tag_name ON tbl_tag(tag_name(255));