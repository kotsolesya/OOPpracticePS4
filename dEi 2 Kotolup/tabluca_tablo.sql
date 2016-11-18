-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Ноя 18 2016 г., 07:00
-- Версия сервера: 5.5.24-log
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `lab1bd`
--

-- --------------------------------------------------------

--
-- Структура таблицы `tabluca_tablo`
--

CREATE TABLE IF NOT EXISTS `tabluca_tablo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Punct_vidpravku` text NOT NULL,
  `Punct_prubutty` text NOT NULL,
  `Chas_vidpravku` text NOT NULL,
  `Chas_prubutty` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `id_2` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Дамп данных таблицы `tabluca_tablo`
--

INSERT INTO `tabluca_tablo` (`id`, `Punct_vidpravku`, `Punct_prubutty`, `Chas_vidpravku`, `Chas_prubutty`) VALUES
(1, 'Kyiv', 'Kharcov', '08:00:00', '15:35:00'),
(2, 'Chercassy', 'Vinnicha', '12:30:00', '16:00:00'),
(3, 'Chercassy', 'Kirovograd', '15:45:00', '18:35:00'),
(4, 'Dnipropetrovsk', 'Kyiv', '10:35:00', '14:25:00'),
(5, 'Symu', 'Lviv', '07:10:00', '17:15:00'),
(6, 'Dnipropetrovsk', 'Chercassy', '11:50:00', '16:45:00'),
(7, 'Zaporizzy', 'Kyiv', '09:15:00', '15:20:00');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
