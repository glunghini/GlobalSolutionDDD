-- LIMPA AS TABELAS ANTES DE INSERIR (para evitar conflitos)
DELETE FROM matriculas;
DELETE FROM trilha_competencia;
DELETE FROM competencias;
DELETE FROM trilhas;
DELETE FROM usuarios;

-- =======================
-- USUÁRIOS
-- =======================
INSERT INTO usuarios (id, nome, email, area_atuacao, nivel_carreira, data_cadastro)
VALUES
(1, 'João Silva', 'joao.silva@email.com', 'Tecnologia', 'Intermediário', '2025-11-12'),
(2, 'Maria Souza', 'maria.souza@email.com', 'Educação', 'Iniciante', '2025-11-12');

-- =======================
-- TRILHAS
-- =======================
INSERT INTO trilhas (id, nome, descricao, foco_principal, nivel, carga_horaria)
VALUES
(1, 'Java Avançado', 'Trilha focada em tópicos avançados de Java', 'Spring Boot', 'Avançado', 40),
(2, 'Python para Dados', 'Análise de dados e machine learning', 'Pandas e Scikit-Learn', 'Intermediário', 35);

-- =======================
-- COMPETÊNCIAS
-- =======================
INSERT INTO competencias (id, nome, descricao, categoria)
VALUES
(1, 'Comunicação', 'Capacidade de transmitir informações de forma clara e eficaz', 'Soft Skill'),
(2, 'Trabalho em Equipe', 'Colaboração eficiente em grupo', 'Soft Skill'),
(3, 'Resolução de Problemas', 'Analisar e resolver problemas complexos', 'Hard Skill');

-- =======================
-- MATRÍCULAS
-- =======================
INSERT INTO matriculas (id, data_inscricao, status, usuario_id, trilha_id)
VALUES
(1, '2025-11-12', 'Ativa', 1, 1),
(2, '2025-11-12', 'Concluída', 2, 2);

-- =======================
-- RELAÇÃO TRILHA x COMPETÊNCIA
-- =======================
INSERT INTO trilha_competencia (trilha_id, competencia_id)
VALUES
(1, 1),
(1, 3),
(2, 2);

ALTER TABLE usuarios ALTER COLUMN id RESTART WITH 3;
ALTER TABLE trilhas ALTER COLUMN id RESTART WITH 3;
ALTER TABLE competencias ALTER COLUMN id RESTART WITH 4;
ALTER TABLE matriculas ALTER COLUMN id RESTART WITH 3;

