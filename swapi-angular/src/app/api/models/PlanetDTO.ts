/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

import type { SearchItemDTO } from './SearchItemDTO';

export type PlanetDTO = {
    orbital_period?: string;
    rotation_period?: string;
    surface_water?: string;
    climate?: string;
    created?: string;
    diameter?: string;
    edited?: string;
    gravity?: string;
    name?: string;
    population?: string;
    terrain?: string;
    url?: string;
    films?: Array<string>;
    filmItems?: Array<SearchItemDTO>;
    residents?: Array<string>;
    residentItems?: Array<SearchItemDTO>;
};

