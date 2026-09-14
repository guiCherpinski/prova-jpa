-- =============================================================================
-- CARGA DE DADOS DE TESTE: TRANSFORMADORES
-- =============================================================================
INSERT INTO tb_transformadores ( numero_serie, modelo, subestacao, potencia_kva, limit_temp_oleo, limit_temp_enrol)
VALUES ( 'TRF-2026-1001', 'Transformador Trifásico de Força 15MVA', 'Subestação Central - Setor A', 15000.00, 85.00, 105.00);

INSERT INTO tb_transformadores (numero_serie, modelo, subestacao, potencia_kva, limit_temp_oleo, limit_temp_enrol)
VALUES ('TRF-2026-1002', 'Transformador Elevador de Tensão 30MVA', 'Subestação Norte - Setor B', 30000.00, 80.00, 100.00);

-- =============================================================================
-- CARGA DE DADOS DE TESTE: TÉCNICOS
-- =============================================================================
INSERT INTO tb_tecnico (cpf, nome, especialidade, email)
VALUES ( '11122233344', 'Carlos Eduardo Silva', 'Eletrotécnica de Alta Tensão', 'carlos.silva@industria.com');

INSERT INTO tb_tecnico ( cpf, nome, especialidade, email)
VALUES ( '55566677788', 'Mariana Oliveira Santos', 'Termografia e Análise de Óleo', 'mariana.santos@industria.com');

INSERT INTO tb_tecnico (cpf, nome, especialidade, email)
VALUES ( '99988877766', 'Roberto Alves Lima', 'Proteção e Automação', 'roberto.lima@industria.com');

-- =============================================================================
-- CARGA DE DADOS DE TESTE: RELACIONAMENTO MANY-TO-MANY (TRANSFORMADOR_TECNICO)
-- =============================================================================
-- Transformador 1 possui os técnicos 1 e 2
INSERT INTO transformador_tecnico (transformador_id, tecnico_id) VALUES (1, 1);
INSERT INTO transformador_tecnico (transformador_id, tecnico_id) VALUES (1, 2);

-- Transformador 2 possui os técnicos 2 e 3 (Mariana atende a ambos os transformadores)
INSERT INTO transformador_tecnico (transformador_id, tecnico_id) VALUES (2, 2);
INSERT INTO transformador_tecnico (transformador_id, tecnico_id	) VALUES (2, 3);

-- =============================================================================
-- CARGA DE DADOS DE TESTE: LEITURAS E ALERTAS
-- =============================================================================
INSERT INTO tb_leitura_termica ( transf_id, temp_oleo, temp_enrolamento, data_hora)
VALUES (1, 89.00, 110.50, '2026-09-10 12:00:00');

INSERT INTO tb_alerta_termico (transf_id, leitura_id, data_alerta, tipo, descricao)
VALUES (1, 1, '2026-09-10 12:00:05', 'SOBREAQUECIMENTO_CRITICO', 'muito grave');


