-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 06-Abr-2018 às 01:14
-- Versão do servidor: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `escolajava_bd`
--
CREATE DATABASE IF NOT EXISTS `escolajava_bd` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `escolajava_bd`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `idAluno` int(11) NOT NULL,
  `nomeAluno` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`idAluno`, `nomeAluno`) VALUES
(1, 'Carmel Hornak'),
(2, 'Jonie Fail'),
(3, 'Evie Doan'),
(4, 'Shayna Johnsrud'),
(5, 'Gricelda Gartland'),
(6, 'Vicki Schild'),
(7, 'Shyla Cothron'),
(8, 'Estrella Coghill'),
(9, 'Trenton Blakeman'),
(10, 'Domenic Such'),
(11, 'Tyree Mcinturff'),
(12, 'Aurore Markell'),
(13, 'Gerard Lovvorn'),
(14, 'Neely Roeser'),
(15, 'Doria Pfeiffer'),
(16, 'Cecille Colucci');

-- --------------------------------------------------------

--
-- Estrutura da tabela `materia`
--

CREATE TABLE `materia` (
  `idmateria` int(11) NOT NULL,
  `nomeMateria` varchar(200) NOT NULL,
  `nomeProfessor` varchar(200) NOT NULL,
  `horasAula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `materia`
--

INSERT INTO `materia` (`idmateria`, `nomeMateria`, `nomeProfessor`, `horasAula`) VALUES
(1, 'Desenvolvimento de Sistemas', 'Professor Cezar', 200),
(2, 'Banco de Dados', 'Professor LC', 200),
(3, 'Modelagem de Software', 'Professora Mary', 200);

-- --------------------------------------------------------

--
-- Estrutura da tabela `presencadia`
--

CREATE TABLE `presencadia` (
  `idPresencaDia` int(11) NOT NULL,
  `idAluno_PresencaDia` int(11) NOT NULL,
  `idMateria_PresencaDia` int(11) NOT NULL,
  `diaFalta` int(11) NOT NULL,
  `faltas` int(11) NOT NULL,
  `presencas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `presencadia`
--

INSERT INTO `presencadia` (`idPresencaDia`, `idAluno_PresencaDia`, `idMateria_PresencaDia`, `diaFalta`, `faltas`, `presencas`) VALUES
(1, 16, 1, 2147483647, 0, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`idAluno`);

--
-- Indexes for table `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idmateria`);

--
-- Indexes for table `presencadia`
--
ALTER TABLE `presencadia`
  ADD PRIMARY KEY (`idPresencaDia`),
  ADD KEY `idAluno_PresencaDia_idx` (`idAluno_PresencaDia`),
  ADD KEY `idMateria_PresencaDia_idx` (`idMateria_PresencaDia`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `idAluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `materia`
--
ALTER TABLE `materia`
  MODIFY `idmateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `presencadia`
--
ALTER TABLE `presencadia`
  MODIFY `idPresencaDia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `presencadia`
--
ALTER TABLE `presencadia`
  ADD CONSTRAINT `idAluno_PresencaDia` FOREIGN KEY (`idAluno_PresencaDia`) REFERENCES `aluno` (`idAluno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idMateria_PresencaDia` FOREIGN KEY (`idMateria_PresencaDia`) REFERENCES `materia` (`idmateria`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
