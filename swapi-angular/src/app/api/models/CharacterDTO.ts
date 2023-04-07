/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

import type { SearchItemDTO } from './SearchItemDTO';

export type CharacterDTO = {
    birth_year?: string;
    eye_color?: string;
    hair_color?: string;
    skin_color?: string;
    gender?: string;
    height?: string;
    homeworld?: string;
    homeworldItem?: SearchItemDTO;
    mass?: string;
    name?: string;
    edited?: string;
    created?: string;
    url?: string;
    films?: Array<string>;
    filmItems?: Array<SearchItemDTO>;
    species?: Array<string>;
    speciesItems?: Array<SearchItemDTO>;
    starships?: Array<string>;
    starshipItems?: Array<SearchItemDTO>;
    vehicles?: Array<string>;
    vehicleItems?: Array<SearchItemDTO>;
};

