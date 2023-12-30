import { combineReducers} from 'redux';
import { manageCancellation,manageReservation,manageamount } from './reservationreducers';

export const railwayStore=combineReducers({
    reservationList:manageReservation,
    cancellationList:manageCancellation,
    amount:manageamount
})