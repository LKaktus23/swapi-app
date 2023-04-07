/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

import type { SearchItemDTO } from './SearchItemDTO';

export type SpeciesDTO = {
    average_height?: string;
    average_lifespan?: string;
    eye_colors?: string;
    hair_colors?: string;
    skin_colors?: string;
    classification?: string;
    created?: string;
    designation?: string;
    edited?: string;
    homeworld?: string;
    homeworldItem?: SearchItemDTO;
    language?: string;
    name?: string;
    url?: string;
    people?: Array<string>;
    characterItems?: Array<SearchItemDTO>;
    films?: Array<string>;
    filmItems?: Array<SearchItemDTO>;
};

