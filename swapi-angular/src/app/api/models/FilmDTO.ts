/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

import type { SearchItemDTO } from './SearchItemDTO';

export type FilmDTO = {
    episode_id?: string;
    opening_crawl?: string;
    release_date?: string;
    created?: string;
    director?: string;
    edited?: string;
    producer?: string;
    title?: string;
    url?: string;
    characters?: Array<string>;
    characterItems?: Array<SearchItemDTO>;
    planets?: Array<string>;
    planetItems?: Array<SearchItemDTO>;
    species?: Array<string>;
    speciesItems?: Array<SearchItemDTO>;
    starships?: Array<string>;
    starshipItems?: Array<SearchItemDTO>;
    vehicles?: Array<string>;
    vehicleItems?: Array<SearchItemDTO>;
};

